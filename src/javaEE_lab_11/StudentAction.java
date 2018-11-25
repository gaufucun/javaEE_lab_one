package javaEE_lab_11;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import load.infoSQL;
import load.infoSQLDAO;

public class StudentAction extends ActionSupport{
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 public Student student0;
     public Student student1;
     public Student student2;
     public Student student3;
     public String  one;
     public String  two;
     public String  condition;
 

 	private String filename;
 	private File file;
     
     public List<Student> list_info = new ArrayList<Student>();
     public List<Student> list_show = new ArrayList<Student>();
     public int  i=0;

 
     public String show() {
    	
    	 student0 = new Student("0001", "张一", 10);
    	 student1 = new Student("0004", "张无忌", 20);
    	
    	 return "show";
     }
    
     public String find() {
    	 student0 = new Student("0001", "张一", 10);
    	 student1 = new Student("0004", "张无忌", 20);
    	 student2 = new Student("0003", "陈国祥", 20);
    	 student3 = new Student("0007", "邵仕杰", 18);
    	 list_info.add(student0);
    	 list_info.add(student1);
    	 list_info.add(student2);
    	 list_info.add(student3);
    	
    	 System.out.println(one+"  "+two+"  "+condition);
    	 
    	 for(int i=0;i<list_info.size();i++) {
    	 if(one.equals("name")) {
    		 if(two.equals("包含")) {
//    			 if("张一".indexOf(condition)!=-1) 
//    				 i=1;
//    			 if("张无忌".indexOf(condition)!=-1) 
//    				 i=2;
//    			 if("张一".indexOf(condition)!=-1&& "张无忌".indexOf(condition)!=-1)
//    				 i=3;
    			 if(list_info.get(i).name.indexOf(condition)!=-1) {
    				 list_show.add(list_info.get(i));
    				
    			 }
    			
    		 } 
//    		 }
    	 }
    		 
    	 
    	 if(one.equals("name")) {
//    		 if(two.equals("等于")) {
//    			 if("张一".equals(condition)) 
//    				 i=1;
//    			 else if("张无忌".equals(condition)) 
//    				 i=2;
    		 if(list_info.get(i).name.equals(condition)) {
				 list_show.add(list_info.get(i));
				 
			 }	
    			
    				 
//    		 }
    	 }
    	 
    	 if(one.equals("age")) {
    		 int num=Integer.parseInt(condition);
    		 System.out.println(num);
    		 if(two.equals("大于")) {
//    			 if(10>num)	 
//    				 i=1;
//    			 if(20>num)
//    				 i=2;
//    			 if(10>num&&20>num)
//    				 i=3;
    			 if(list_info.get(i).age>num) {
    				 list_show.add(list_info.get(i));
    				
    			 }
    				 
    			 
    		   
    		 }
    		 
    		 if(two.equals("大于等于")) {
//    			 if(10>=num)	 
//    				 i=1;
//    			 if(20>=num)
//    				 i=2;
//    			 if(10>=num&&20>=num)
//    				 i=3;
    			 if(list_info.get(i).age>=num) {
    				 list_show.add(list_info.get(i));
    				
    				 }
    			 
    		 }
    		 
    		 if(two.equals("小于等于")) {
//    			 if(10<=num)	 
//    				 i=1;
//    			 if(20<=num)
//    				 i=2;
//    			 if(10<=num&&20<=num)
//    				 i=3;
    			 if(list_info.get(i).age<=num) {
    				 list_show.add(list_info.get(i));
    				
    			 }
    		 }
    		 
    		 if(two.equals("小于")) {
//    			 if(10<num)	 
//    				 i=1;
//    			 if(20<num)
//    				 i=2;
//    			 if(10<num&&20<num)
//    				 i=3;
    			 if(list_info.get(i).age<num) {
    				 list_show.add(list_info.get(i));
    				
    			 }
    			
    		 }
    		 
    	 }
    	
    	 
    	 }
    	 
    	 return "show";
     }
     
     
     public List<Student> getList_show() {
		return list_show;
	}

	public void setList_show(List<Student> list_show) {
		this.list_show = list_show;
	}

	//实现get set方法
	public Student getStudent0() {
		return student0;
	}



	public void setStudent0(Student student0) {
		this.student0 = student0;
	}

	
	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}






	
     
}
