package private_tags;


import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by mrahbari on 10/06/2015.
 *
 *
 * To Check it use below url address
 * http://localhost:8099/jsps/private_tags/index.jsp?status=ok
 */

public class StatusHandler extends TagSupport {
    String status;

    @Override
    public int doStartTag() throws JspException {

        try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();

            // do something based on tags value
            ServletRequest request = pageContext.getRequest();
            status = request.getParameter("status");
            if (status != null)
                return EVAL_BODY_INCLUDE;   // print tag content
            else {
                out.println("\n\rStatus was defined!");
                return SKIP_BODY;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}

