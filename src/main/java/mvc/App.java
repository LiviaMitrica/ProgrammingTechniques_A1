package mvc;
import controller.CController;
import model.Polynomial;
import view.CView;
//import view.TestView;

public class App 
{
    public static void main(String[] args) {
        
        Polynomial     model      = new Polynomial();
        CView          view       = new CView(model);
		@SuppressWarnings("unused")
		CController controller    = new CController(model, view);
    }

}
