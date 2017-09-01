package com.ajay.BowlingEngine.service;

import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

import com.ajay.BowlingEngine.dto.Frame;

@Component
public class ScoreCalculatorImpl implements ScoreCalculator {

	@Override
	public List<Frame> calculateScore(List<Frame> frames) {
		frames = frameScoreCalculator(frames);
		return frames;
	}

	
	/**
	 * Calculates score on below conditions
	 * 1. If currentFrame is Strike then total score will be sum of current frame score and score of next 2 chances.
	 * 2. If currentFrame is Spare then total score will be sum of current frame and score of next chance.
	 * 3. If current frame is neither Strike or Spare then current Frame score will sum of 2 chances of the frame.
	 * 
	 * @param frameList
	 * @return
	 */
	private static List<Frame> frameScoreCalculator(List<Frame> frameList) {
		
		//Set Strike or Spare for each frame.
		setSpareOrStrike(frameList);
		
		ListIterator<Frame> iterator = (ListIterator<Frame>) frameList.listIterator();
		while (iterator.hasNext()) {

			Frame nextFrame = null;
			Frame nextToNextFrame = null;

			Frame currentFrame = iterator.next();

			if (iterator.hasNext()) {
				nextFrame = iterator.next();
				if (iterator.hasNext()) {
					nextToNextFrame = iterator.next();
					iterator.previous();
				}
				iterator.previous();
			}

			// If frame is Strike
			if (currentFrame.isStrike()) {
				if (null != nextFrame) {
					if (nextFrame.isNormal() || nextFrame.isSpare()) {
						currentFrame.setFrameScore(10 + nextFrame.getChance1Score() + nextFrame.getChance2Score());
						calculateTotalScore(frameList,iterator.nextIndex()-1);
					} else if (null != nextToNextFrame && nextFrame.isStrike() && nextToNextFrame.isNormal()) {
						currentFrame.setFrameScore(10 + 10 + nextToNextFrame.getChance1Score());
						calculateTotalScore(frameList,iterator.nextIndex()-1);
					} else if (null != nextToNextFrame && nextFrame.isStrike() && nextToNextFrame.isStrike()) {
						currentFrame.setFrameScore(30);
						calculateTotalScore(frameList,iterator.nextIndex()-1);
					}
				}
			}

			// If frame is spare
			else if (currentFrame.isSpare()) {
				if (null != nextFrame){
					currentFrame.setFrameScore(10 + nextFrame.getChance1Score());
					calculateTotalScore(frameList,iterator.nextIndex()-1);
				}	
			}

			// If frame is Normal
			else {

				currentFrame.setFrameScore(currentFrame.getChance1Score() + currentFrame.getChance2Score());
				calculateTotalScore(frameList,iterator.nextIndex()-1);
			}

		}

		return frameList;

	}
	
	/**
	 * 
	 * Calculates total score of the Player till that frame.
	 * 
	 * @param frames
	 * @param index
	 */
	private static void calculateTotalScore(List<Frame> frames, int index){
		if(index>0){
			ListIterator<Frame> listIterator = frames.listIterator(index);
			int currentFrameScore = frames.get(index).getFrameScore(); 
				if(listIterator.hasPrevious()){
					frames.get(index).setFrameScore(currentFrameScore+listIterator.previous().getFrameScore());
				}
		}
	}
	
	/**
	 * Method to check whether strike or spare. 
	 * @param frames
	 */
	private static void setSpareOrStrike(List<Frame> frames){
		frames.forEach(f->{
			if(f.getChance1Score()==10)
				f.setStrike(true);
			else if(f.getChance1Score()+f.getChance2Score()==10)
				f.setSpare(true);
			else
				f.setNormal(true);
		});
	}

}
