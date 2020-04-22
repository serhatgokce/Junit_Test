package demo.junit_class_demo.grades;

import org.junit.Test;
import static org.mockito.Mockito.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.junit.Assert;
import org.junit.Assert.*;
import java.io.*;

public class HistogramGeneratorTest {
	//alttaki method etkilemedi hocam anlamadım nedenini
	@Test
	public void test_generate_normal() {
		JFreeChart chart = mock(JFreeChart.class);
		ChartIO io = mock(ChartIO.class);
		HistogramGenerator k=mock(HistogramGenerator.class);
		k.generateHistogram("a","b");
		
		doNothing().when(k).generateHistogram(isA(String.class), isA(String.class));
		verify(k, times(1)).generateHistogram("a", "b");
	}

 	@Test 
	public void test_calculateFrequencies() {
		int demo_grades[]= {0,0,0,0};
		ChartIO io = mock(ChartIO.class);
		HistogramGenerator k=new HistogramGenerator(io);
		Assert.assertNotNull(k.calculateFrequencies(demo_grades));
		
		
	}
 	@Test
	public void test_exportchart() {
 		JFreeChart chart = mock(JFreeChart.class);
 		ChartIO io = mock(ChartIO.class);
 		HistogramGenerator k=new HistogramGenerator(io);
 		doNothing().when(io).writeFile(isA(String.class), isA(JFreeChart.class));
 		k.exportChart("sldkvksd",chart);
 		verify(io,times(1)).writeFile("sldkvksd",chart);
 		
		
	} 	
 	@Test
 	public void test_createChart() {
 		int demo_grades[]= {0,0,0,0};
		ChartIO io = mock(ChartIO.class);
		HistogramGenerator k=new HistogramGenerator(io);
		Assert.assertNotNull(k.createChart(demo_grades));
 		
 	}

 

	
}
