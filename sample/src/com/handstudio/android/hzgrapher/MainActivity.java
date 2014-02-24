package com.handstudio.android.hzgrapher;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.handstudio.android.hzgrapherlib.graphview.GraphView;
import com.handstudio.android.hzgrapherlib.vo.linegraph.Graph;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraphVO;

public class MainActivity extends Activity {

	private ViewGroup layoutGraphView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		layoutGraphView = (ViewGroup) findViewById(R.id.layoutGraphView);

		
		setLineGraph();
		
	}

	private void setLineGraph() {
		//all setting
		LineGraphVO vo = makeLineGraphAllSetting();
		
		//default setting
//		LineGraphVO vo = makeLineGraphDefaultSetting();
		
		layoutGraphView.addView(new GraphView(this, vo));
	}
	
	private LineGraphVO makeLineGraphDefaultSetting() {
		
		String[] legendArr 	= {"1","2","3","4","5"};
		float[] graph1 		= {500,100,300,200,100};
		float[] graph2 		= {000,100,200,100,200};
		float[] graph3 		= {200,500,300,400,000};
		
		List<Graph> arrGraph 		= new ArrayList<Graph>();
		arrGraph.add(new Graph(0xaa66ff33, graph1));
		arrGraph.add(new Graph(0xaa00ffff, graph2));
		arrGraph.add(new Graph(0xaaff0066, graph3));
		
		LineGraphVO vo = new LineGraphVO(legendArr, arrGraph);
		return vo;
	}

	private LineGraphVO makeLineGraphAllSetting() {
		//BASIC LAYOUT SETTING
		//padding
		int paddingBottom 	= LineGraphVO.DEFAULT_PADDING;
		int paddingTop 		= LineGraphVO.DEFAULT_PADDING;
		int paddingLeft 	= LineGraphVO.DEFAULT_PADDING;
		int paddingRight 	= LineGraphVO.DEFAULT_PADDING;

		//graph margin
		int marginTop 		= LineGraphVO.DEFAULT_MARGIN_TOP;
		int marginRight 	= LineGraphVO.DEFAULT_MARGIN_RIGHT;

		//max value
		int maxValue 		= LineGraphVO.DEFAULT_MAX_VALUE;

		//increment
		int increment 		= LineGraphVO.DEFAULT_INCREMENT;
		
		//GRAPH SETTING
		String[] legendArr 	= {"1","2","3","4","5"};
		float[] graph1 		= {500,100,300,200,100};
		float[] graph2 		= {000,100,200,100,200};
		float[] graph3 		= {200,500,300,400,000};
		
		List<Graph> arrGraph 		= new ArrayList<Graph>();
		
		arrGraph.add(new Graph(0xaa66ff33, graph1, R.drawable.ic_launcher));
		arrGraph.add(new Graph(0xaa00ffff, graph2));
		arrGraph.add(new Graph(0xaaff0066, graph3));
		
		LineGraphVO vo = new LineGraphVO(
				paddingBottom, paddingTop, paddingLeft, paddingRight,
				marginTop, marginRight, maxValue, increment, legendArr, arrGraph);
		
		//use icon
//		arrGraph.add(new Graph(0xaa66ff33, graph1, R.drawable.icon1));
//		arrGraph.add(new Graph(0xaa00ffff, graph2, R.drawable.icon2));
//		arrGraph.add(new Graph(0xaaff0066, graph3, R.drawable.icon3));
		
//		LineGraphVO vo = new LineGraphVO(
//				paddingBottom, paddingTop, paddingLeft, paddingRight,
//				marginTop, marginRight, maxValue, increment, legendArr, arrGraph, R.drawable.bg);
		return vo;
	}
}
