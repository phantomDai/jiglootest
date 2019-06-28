package test;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class TestJFileChooseer {
	
	public static void main(String[] args) {
		JFileChooser jf = new JFileChooser();
		jf.setApproveButtonText("导入");
		jf.setCurrentDirectory(new File("."));
		jf.setMultiSelectionEnabled(false);
		jf.setFileFilter(new MyFileFilter("xml"));
		jf.setDialogTitle("请选择要导入的测试集文件");
		jf.showOpenDialog(null);
		File f = jf.getSelectedFile();
		if (f != null)
			System.out.println(f.getPath());
	}
	
	public static class MyFileFilter extends FileFilter {
		
		private String ext;
		
		public MyFileFilter(String extString) {
			ext = extString;
		}
		
		public boolean accept(File f) {
	        if (f.isDirectory()) {  
	            return true;  
	        }
	        String extension = getExtension(f);
	        if (extension.toLowerCase().equals(this.ext.toLowerCase()))
	        {
	            return true;
	        }
	        return false;
	    }
		
		 public String getDescription() {
			 return this.ext.toUpperCase();
		 }
		
		private String getExtension(File f) {
	        String name = f.getName();
	        int index = name.lastIndexOf('.');
	        if (index == -1)
	        {
	            return "";
	        }
	        else
	        {
	            return name.substring(index + 1).toLowerCase();
	        }
	    }
	}

}
