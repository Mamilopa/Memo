package controllers;



import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Memo;


@WebServlet({"/MemoServlet", "/memos"})
public class MemoServlet extends HttpServlet {

    private static final long serialVersionUID = -7843898075264520941L;
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sendResponse(request, response);
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        config.getServletContext().getRequestDispatcher("/WEB-INF/memos.jsp").forward(request, response);    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        final String button = request.getParameter("button");
        switch (button) {
            case "reset":
                actionReset(request);
                sendResponse(request, response);
                break;
            case "save":
                actionAddMemo(request, response);
                sendResponse(request, response);
                break;
            default:
                sendResponse(request, response);

        }

    }
    private synchronized void actionReset(HttpServletRequest request){
        List<Memo> memos= getMemos (request);
        memos.clear();
    }
    
    
    private synchronized void actionAddMemo(HttpServletRequest request, HttpServletResponse response){
        String memoDescr = request.getParameter("memo");
        if (memoDescr !=null && !memoDescr.isEmpty()){
            List<Memo> memos= getMemos(request);
            Memo memo = new Memo();
            memo.setDescription(memoDescr);
            memo.setCreated(new Date());
            memos.add(memo);
                 }else{
            request.setAttribute("err", "Please, enter a memo!");
        }
    }
    
    private List<Memo> getMemos(HttpServletRequest request){
        HttpSession session= request.getSession();
        List<Memo> memos= (List<Memo>) session.getAttribute("memos");
        if(memos== null){
            memos= new LinkedList<>();
            session.setAttribute("memos", memos);
        }
        return memos;
    }
    

}
