package cn.org.kkl.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.org.kkl.model.Course;
import cn.org.kkl.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static Logger log = LoggerFactory.getLogger(CourseController.class);
	
	
	private CourseService courseService;
	
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId,Model model) {
		log.debug("CourseController.viewCourse,courseid={}",courseId);
		Course course= courseService.getCourseById(courseId);
		model.addAttribute(course);
		return "course_overview";
	}
	
	@RequestMapping(value="/view2/{courseId}",method=RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") Integer courseId,Map<String,Object> model) {
		log.debug("CourseController.viewCourse2,courseid={}",courseId);
		Course course= courseService.getCourseById(courseId);
		model.put("course", course);
		return "course_overview";
	}
	
	@RequestMapping(value="/view3",method=RequestMethod.GET)
	public String viewCourse3(HttpServletRequest request) {
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		log.debug("CourseController.viewCourse2,courseid={}",courseId);
		Course course= courseService.getCourseById(courseId);
		request.setAttribute("course", course);
		return "course_overview";
	}
	
	@RequestMapping(value="/admin",method=RequestMethod.GET,params="add")
	public String createCourse() {
		
		return "course_admin/edit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String courseSave(@ModelAttribute Course course) {
		System.out.println("course form submit infomation:"+course.toString());
		
		course.setId(123);
		
		//重定向
		return "redirect:/courses/view2/"+course.getId();
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String showUploadPage() {
		
		return "course_admin/file";
	}
	
	//copy path:  D:\2018eclipse\temp
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			System.out.println("正在处理文件"+file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\2018eclipse\\temp\\",System.currentTimeMillis()+file.getOriginalFilename()));
		}
		return "success";
	}
	
	@RequestMapping(value="/{courseId}",method=RequestMethod.GET)
	@ResponseBody
	public Course getCourseInJson(@PathVariable Integer courseId) {
		return courseService.getCourseById(courseId);
	}
	
	@RequestMapping(value="/jsonType/{courseId}",method=RequestMethod.GET)
	public ResponseEntity<Course> getCourse2InJson(@PathVariable Integer courseId){
		Course course =courseService.getCourseById(courseId);
		return new ResponseEntity<Course>(course,HttpStatus.OK);
	}

	

}
