package private_tags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by mrahbari on 10/06/2015.
 */

public class SubstrHandler extends TagSupport {
    private String input;
    private int start;
    private int end;

    @Override
    public int doStartTag() throws JspException {

        try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();

            //Perform substr operation on string.
            out.println(input.substring(start, end));

            /*// do something based on tags value
            ServletRequest request = pageContext.getRequest();
            String status = request.getParameter("status");
            if (status != null)
                out.println("\n\rStatus was defined!");*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }
}

