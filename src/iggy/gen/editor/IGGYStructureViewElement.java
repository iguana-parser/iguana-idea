package iggy.gen.editor;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import iggy.gen.lang.IGGYFile;
import iggy.gen.psi.IEbnfElement;
import iggy.gen.psi.IRule;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anastasia Izmaylova on 13/10/15.
 */

public class IGGYStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private PsiElement element;

    public IGGYStructureViewElement(PsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return element instanceof NavigationItem
                && ((NavigationItem) element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element instanceof NavigationItem
                && ((NavigationItem) element).canNavigateToSource();
    }

    @Override
    public String getAlphaSortKey() {
        return element instanceof PsiNamedElement? ((PsiNamedElement) element).getName() : element.getText();
    }

    @Override
    public ItemPresentation getPresentation() {
        return element instanceof NavigationItem? ((NavigationItem) element).getPresentation() : null;
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if (element instanceof IGGYFile) {
            List<TreeElement> treeElements = new ArrayList<>();
            List<PsiElement> elements = ((IEbnfElement) ((IGGYFile) element).getFirstChild()).getElements();
            for (PsiElement element : elements) {
                if (element instanceof IRule)
                    treeElements.add(new IGGYStructureViewElement(element));
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        }
        return new TreeElement[0];
    }
}
