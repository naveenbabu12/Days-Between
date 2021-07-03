package com.daysbetween;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.daysbetween.service.DaysbetweenService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DaysBetweenTest {

	@Autowired
	DaysbetweenService daysbetweenService;
	
	@Test
	public void testDatesSet1() {
		String output = daysbetweenService.prepareOutput("01/08/2019", "10/05/2021");
		assertTrue(output.equals("<b>Output: </b>The number of days between <b>August 01st 2019 and May 10th 2021 is </b>648 days<br /><br /><br />"));
	}
	
	@Test
	public void testDatesSet2() {
		String output = daysbetweenService.prepareOutput("22/12/2018", "12/05/2019");
		assertTrue(output.equals("<b>Output: </b>The number of days between <b>December 22th 2018 and May 12th 2019 is </b>141 days<br /><br /><br />"));
	}
	
	@Test
	public void testDays() {
		Integer outputDays = daysbetweenService.getDays("22/12/2018", "12/05/2019");
		assertTrue(outputDays.equals(141));
	}
	
	@Test
	public void testdateToWord() {
		String outputFormat = daysbetweenService.dateToWordFormat("22/12/2018");
		assertTrue(outputFormat.equals("December 22th 2018"));
	}
	
	@Test
	public void testdateToWordNegative() {
		String outputFormat = daysbetweenService.dateToWordFormat("22/12/2018");
		assertFalse(outputFormat.equals("Dec 22th 2018"));
	}
}
