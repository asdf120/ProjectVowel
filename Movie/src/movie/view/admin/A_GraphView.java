package movie.view.admin;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class A_GraphView extends JPanel{
	
	public A_GraphView(){
		
		JPanel graph = new JPanel();
		MovieGraph demo = new MovieGraph();			 // (2) DB에서 가져온 값으로 차트 
		JFreeChart chart = demo.getChart();     
		ChartPanel chartPanel=new ChartPanel(chart); 
		
		setLayout(new BorderLayout());
        add(chartPanel,BorderLayout.CENTER);
        setSize(800,400); 
        setVisible(true);
	}
	
	
}
