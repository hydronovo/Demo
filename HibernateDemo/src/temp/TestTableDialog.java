package temp;
 
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
/**
 * Example dialog
 *
 * @author Aleksandr
 */
public class TestTableDialog extends JDialog {
 
 
    public TestTableDialog(){
 
        BooleanTableModel tableModel = new BooleanTableModel(
                new BooleanTableModel.RowItem(true, "The first true"),
                new BooleanTableModel.RowItem(null, "<< must be empty"),
                new BooleanTableModel.RowItem(true, "The second true"),
                new BooleanTableModel.RowItem(null, "<< the other empty"),
                new BooleanTableModel.RowItem(null, "<< the last empty"),
                new BooleanTableModel.RowItem(false, "Finally false")
        );
 
        JTable table = new JTable();
        table.setDefaultRenderer(Boolean.class, new BooleanCellRenderer());
        table.setModel(tableModel);
 
        JScrollPane tableScroll = new JScrollPane();
        tableScroll.getViewport().setView(table);
 
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().add(tableScroll);
        this.add(tableScroll);
        this.setSize(320, 240);
        this.setLocationRelativeTo(null); // for center location
        this.setVisible(true);
 
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestTableDialog();
    }
 
}