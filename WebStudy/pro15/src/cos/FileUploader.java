package cos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUpload")
public class FileUploader extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String folderName = "uploadFiles";
		String folderDir = "./";
		// String saveFolder = "./uploadFiles"
		// 저장디렉터리 경로는 "./"로 시작하도록 하자. (경로가 헷갈릴 수 있기 때문)
		String realPath = request.getServletContext().getRealPath(folderDir + folderName);
		
		System.out.println("파일 업로드 경로 : " + realPath);
		
		String encType = "UTF-8";
		int fileSize = 1024 * 1024 * 5;
		
		MultipartRequest multi = new MultipartRequest(request,
													  realPath,
													  fileSize,
													  encType,
													  new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		request.setAttribute("uploadID", id);
		
		@SuppressWarnings("unchecked")
		Enumeration<String> fileNames = multi.getFileNames();
		List<String> filePathList = new ArrayList<String>();
		
		while(fileNames.hasMoreElements()) {
			String curFileTagName = fileNames.nextElement();
			String curFileName = multi.getFilesystemName(curFileTagName);
			String curFilePath = folderDir + folderName + "/" + curFileName;
			
			filePathList.add(curFilePath);
		}
		request.setAttribute("fileList", filePathList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/using_cos/uploadResult.jsp");
		dispatcher.forward(request, response);
	}
}
