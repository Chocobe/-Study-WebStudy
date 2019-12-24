package sec03.brd02;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board2/*")
public class BoardController2 extends HttpServlet {
	private BoardService2 boardService;
	
	public void init() throws ServletException {
		boardService = new BoardService2();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		doHandle(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		doHandle(request, response);
	}
	
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/articleForm.do")) {
			nextPage = "/board02/articleForm.jsp";
			
		} else if(action.equals("/addArticle.do")) {
			Map<String, String> articleMap = upload(request, response);
			
			String title = articleMap.get("title");
			String content = articleMap.get("content");
			String imageFileName = articleMap.get("imageFileName");
			
			ArticleVO2 articleVO = new ArticleVO2();
			articleVO.setParentNO(0);
			articleVO.setId("hong");
			articleVO.setTitle(title);
			articleVO.setContent(content);
			articleVO.setImageFileName(imageFileName);
			
			boardService.addArticle(articleVO);
			
			nextPage = "/board/listArticles.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		
		String fileDir = "board02/images";
		String realPath = getServletContext().getRealPath(fileDir);
		String encoding = "UTF-8";
		int fileSize = 1024 * 1024 * 10;
		
		MultipartRequest multi = new MultipartRequest(request,
													  realPath,
													  fileSize,
													  encoding,
													  new DefaultFileRenamePolicy());
		
		@SuppressWarnings("unchecked")
		Enumeration<String> fileInputNames = multi.getFileNames();
		while(fileInputNames.hasMoreElements()) {
			String curInputFileName = fileInputNames.nextElement();
			String filesystemName = multi.getFilesystemName(curInputFileName);
			
			articleMap.put(curInputFileName, fileDir + "/" + filesystemName);
		}
		
		@SuppressWarnings("unchecked")
		Enumeration<String> paramNames = multi.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String curInputName = paramNames.nextElement();
			String curInputValue = multi.getParameter(curInputName);
			
			articleMap.put(curInputName, curInputValue);
		}
		
		return articleMap;
	}
}





























