package com.harshita.demo.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.harshita.demo.dao.SectionRepo;
import com.harshita.demo.dao.StudentRepo;
import com.harshita.demo.dao.SubHeadingRepo;


@Controller
@RequestMapping(value = {"/syll"})
public class StudentController {

	@Autowired
	StudentRepo repo;

	@Autowired
	SubHeadingRepo srepo;

	@Autowired
	SectionRepo secrepo;

//	
//	@GetMapping(path = "/CSE", produces = { "application/json" })
//	@ResponseBody getUser() {
//		return repo.findBytopicidGreaterThan(36);
//
//	}
	
	
	
	
//	@GetMapping(path = "/CSE", produces = { "application/json" })
//	List<Student> getUsers() {
//		return repo.findBysubheadingid();
//
//	}

@RequestMapping(value="/ECE")
public ModelAndView ecesyll() // here we taking data(i.e. model) from user
										// and giving a view as a output that is why // we are using modelandview
{
	
	ModelAndView mv = new ModelAndView();
	
		JSONObject object = new JSONObject();
		secrepo.findbybranch("gate_ece").forEach((sectio)->{
			//System.out.println(sectio);
			JSONObject sect = new JSONObject();
			try {
				sect.put("name", sectio.getSectionname());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject secti = new JSONObject();
			srepo.findbytopic(sectio.getSectionid()).forEach((subhea)->{
				JSONObject subh = new JSONObject();
				JSONObject top = new JSONObject();
				try {
					subh.put("name", subhea.getSubheadingname());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(subhea);
				repo.findBysubheading(subhea.getSubheadingid()).forEach((topi)->{
					JSONObject to = new JSONObject();
					try {
						to.put("name", topi.getTopicname());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						top.put(Integer.toString(topi.getTopicid()), to);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(topi);
				});
				try {
					subh.put("data", top);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					secti.put(Integer.toString(subhea.getSubheadingid()), subh);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			try {
				sect.put("data", secti);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				object.put(Integer.toString(sectio.getSectionid()), sect);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println(object);

//		mv.addObject(object); // adding the data ("key",variable name)
//		
		mv.setViewName("getECEsyll.html");
		mv.addObject("listUsers", object);
	    
		return mv;         // returning a modelandview object "<p style=\"color:red;\">duduegd<p>"
	}
	
	
@RequestMapping(value="/CSE", method= {RequestMethod.GET,RequestMethod.POST})
public String csesyll(Model model) // here we taking data(i.e. model) from user
										// and giving a view as a output that is why // we are using modelandview
	{
		
		JSONObject object = new JSONObject();
		secrepo.findbybranch("gate_ece").forEach((sectio)->{
			//System.out.println(sectio);
			JSONObject sect = new JSONObject();
			try {
				sect.put("name", sectio.getSectionname());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject secti = new JSONObject();
			srepo.findbytopic(sectio.getSectionid()).forEach((subhea)->{
				JSONObject subh = new JSONObject();
				JSONObject top = new JSONObject();
				try {
 					subh.put("name", subhea.getSubheadingname());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(subhea);
				repo.findBysubheading(subhea.getSubheadingid()).forEach((topi)->{
					JSONObject to = new JSONObject();
					try {
						to.put("name", topi.getTopicname());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						top.put(Integer.toString(topi.getTopicid()), to);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(topi);
				});
				try {
					subh.put("data", top);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					secti.put(Integer.toString(subhea.getSubheadingid()), subh);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			try {
				sect.put("data", secti);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				object.put(Integer.toString(sectio.getSectionid()), sect);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println(object);
	
		
		
	

	     model.addAttribute("listUsers", object);
		return "getECEsyll";         // returning a modelandview object
	}

	

	
	
	@RequestMapping("/home")
	public ModelAndView home() // here we taking data(i.e. model) from user and giving a view
								// as a output that is why we are using modelandview
	{
		ModelAndView mv = new ModelAndView(); // creating modelandview object

		mv.setViewName("home.html"); // setting the view

		return mv;// returning a modelandview object
	}

	@RequestMapping("/exam1")
	public ModelAndView gate() // here we taking data(i.e. model) from user and giving a view
								// as a output that is why we are using modelandview
	{
		ModelAndView mv = new ModelAndView(); // creating modelandview object

		mv.setViewName("gateBranch.html"); // setting the view

		return mv;// returning a modelandview object
	}
//
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@RequestMapping("/updateStudent")
//	public ModelAndView updateStudent(@RequestParam int sid, String sname) // here we taking data(i.e. model) from user
//																			// and giving a view as a output that is why
//																			// we are using modelandview
//	{
//		ModelAndView mv = new ModelAndView(); // creating modelandview object
//
//		Student student = repo.findById(sid).get();
//		student.setSname(sname);
//		repo.save(student);
//
//		mv.addObject(student); // adding the data ("key",variable name)
//		mv.setViewName("getStudent.jsp"); // setting the view
//
//		return mv;// returning a modelandview object
//	}
////
//	@RequestMapping("/deleteStudent")
//	public ModelAndView deleteStudent(@RequestParam int sid) // here we taking data(i.e. model) from user and giving a
//																// view as a output that is why we are using
//																// modelandview
//	{
//		ModelAndView mv = new ModelAndView(); // creating modelandview object
//
//		repo.deleteById(sid);
//
//		mv.setViewName("home.jsp"); // setting the view
//
//		return mv;// returning a modelandview object
//	}

}
//ModelAndView mv = new ModelAndView("getStudent.jsp"); // creating modelandview object

////	repo.save(student);
//int count = 0;
//int j=0;
//
//for(int k=0;k<2;k++) {
//	System.out.println(secrepo.findBysectionid(k));
//	System.out.println("section printed"+" "+ k);
//		for(j=count;;j++) 
//		{
//			if((srepo.getcount(j,k))==1) 
//			{
//				System.out.print(srepo.findBysubheadingid(j));
//			
//				List<Student> student = repo.findBysubheading(j);
//				student.forEach(e-> System.out.println(e));
//				System.out.println("topic from subheading"+" "+ j+" "+"printed");
//			}
//			else {
//			System.out.println(count+"at else");
//			break;}
//		}
//		count=j+1;
//		System.out.println(count+"new count");
//	}
//System.out.println("end");
