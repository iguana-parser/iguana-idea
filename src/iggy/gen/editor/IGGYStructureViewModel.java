package iggy.gen.editor;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import iggy.gen.editor.IGGYStructureViewElement;
import iggy.gen.lang.IGGYFile;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Anastasia Izmaylova on 13/10/15.
 */

public class IGGYStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

    public IGGYStructureViewModel(PsiFile file) {
        super(file, new IGGYStructureViewElement(file));
    }

    @NotNull
    @Override
    public Sorter[] getSorters() {
        return new Sorter[] { Sorter.ALPHA_SORTER };
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof IGGYFile;
    }
}
