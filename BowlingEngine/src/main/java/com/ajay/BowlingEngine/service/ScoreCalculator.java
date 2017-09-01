package com.ajay.BowlingEngine.service;

import java.util.List;

import com.ajay.BowlingEngine.dto.Frame;

/**
 * 
 * Score Calculator.
 * 
 * @author Ajay
 *
 */
public interface ScoreCalculator {

	public List<Frame> calculateScore(List<Frame> frames);
	
}
