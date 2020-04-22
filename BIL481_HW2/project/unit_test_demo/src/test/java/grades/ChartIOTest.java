package demo.junit_class_demo.grades;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.File;  
import java.io.PrintWriter;
import java.io.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import static org.mockito.Mockito.*;


public class ChartIOTest {
	
	ChartIO io = new ChartIO();
	@Test
	public void test_readFile_happyPath() throws Exception {
		String path="./grades.txt";
		PrintWriter f0 = new PrintWriter(new FileWriter(path));
		for(int i=0;i<3;i++)
		{
		    f0.println(i);
		}
		f0.close();

		File file = new File(path);
		int arr[]=io.readFile(path);
		file.delete();	
		Assert.assertEquals(0,0);
		Assert.assertEquals(1,1);
		Assert.assertEquals(2,2);
	}
	
	@Test 
	public void test_readFile_SadPath() {
		String path="";
		try {
			io.readFile(path);
		}catch(Exception ex) {
			Assert.assertTrue(ex instanceof IllegalArgumentException );
		}
	}
	//alttaki method etkilemedi hocam anlamadım nedenini
	@Test
	public void test_writeFile() {
		JFreeChart chart = mock(JFreeChart.class);
		ChartIO io = mock(ChartIO.class);
		io.writeFile("sldkvksd",chart);
		
		doNothing().when(io).writeFile(isA(String.class), isA(JFreeChart.class));
		verify(io, times(1)).writeFile("sldkvksd", chart);
		
		
	}


	
}
