package com.ajay.BowlingEngine.service;

import java.util.List;

import com.ajay.BowlingEngine.dto.Frame;

public interface ScoreCalculator {

	public List<Frame> calculateScore(List<Frame> frames);
	
}
