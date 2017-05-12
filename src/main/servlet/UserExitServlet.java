package servlet;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pc on 17-5-11.
 */
public class UserExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取session
        HttpSession session = req.getSession();
        //获取用户对象
        User user = (User) session.getAttribute("user");
        //判断用户是否有效
        if (user != null) {
            //将用户对象逐出Session
            session.removeAttribute("user");
            //设置提示信息
            req.setAttribute("info", user.getUsername() + "已成功退出！");
        }
        req.getRequestDispatcher("message.jsp").forward(req, resp);
    }
    /**
     *
     * 1.session.setAttribute()和session.getAttribute()配对使用，作用域是整个会话期间，
     * 在所有的页面都使用这些数据的时候使用。
     *
     * 2.request.setAttribute()和request.getAttribute()配对使用，作用域是请求和被请求页
     *面之间。request.setAttribute()是只在此action的下一个forward需要使用的时候使用；
     *request.getAttribute()表示从request范围取得设置的属性，必须要先setAttribute设置属性
     *，才能通过getAttribute来取得，设置与取得的为Object对象类型。其实表单控件中的Object的
     *name与value是存放在一个哈希表中的，所以在这里给出Object的name会到哈希表中找出对应它的value。
     *setAttribute()的参数是String和Object。
     *
     *
     * 3.request.getParameter()表示接收参数，参数为页面提交的参数。包括：表单提交的参数、URL
     *重写(就是xxx?id=1中的id)传的参数等，因此这个并没有设置参数的方法(没有setParameter())，而且接收
     *参数返回的不是Object，而是String类型。
     *
     *
     * 4.request.getParameter() 和request.getAttribute() 区别

     （1）request.getParameter()取得是通过容器的实现来取得通过类似post，get等方式传入的数据，
     request.setAttribute()和getAttribute()只是在web容器内部流转，仅仅是请求处理阶段。

     （2）request.getParameter()方法传递的数据，会从Web客户端传到Web服务器端，代表HTTP请求数据。
     request.getParameter()方法返回String类型的数据。

     request.setAttribute()和getAttribute()方法传递的数据只会存在于Web容器内部

     还有一点就是，HttpServletRequest类有setAttribute()方法，而没有setParameter()方法。
     *
     *
     * 5.request.getAttribute()与request.setAttribute()

     request.getAttribute("nameOfObj")可得到JSP页面一表单中控件的Value。其实表单控件中的Object的
     name与value是存放在一个哈希表中的，所以在这里给出Object的name会到哈希表中找出对应它的value。

     而不同页面间传值使用request.setAttribute(position, nameOfObj)时，只会从a.jsp到b.jsp一次传递，
     之后这个request就会失去它的作用范围，再传就要再设一个 request.setAttribute()。而使用session.
     setAttribute()会在一个过程中始终保有这个值。

     P.S：JavaScript与JSP中不能相互传值，因为JavaScript运行在客户端，而JSP运行在服务器端。若想使
     它们之间可以相互传递参数，可以在JSP中设置一个hidden控件，用它的value结合上面所说的用法来传递所需的数值

     */
}
