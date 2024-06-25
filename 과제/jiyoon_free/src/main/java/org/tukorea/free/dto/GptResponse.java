package org.tukorea.free.dto;

import java.util.List;

import org.tukorea.free.domain.GptMessageVO;


public class GptResponse {
    private List<Choice> choices;

    public List<Choice> getChoices() {
		return choices;
	}

	public static class Choice {
        private GptMessageVO message;

		public GptMessageVO getMessage() {
			return message;
		}

		public void setMessage(GptMessageVO message) {
			this.message = message;
		}
        
    }
}