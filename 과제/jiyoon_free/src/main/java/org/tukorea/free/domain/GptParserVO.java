package org.tukorea.free.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GptParserVO {

	public ScheduleVO parseScheduleText(String scheduleText) {
		List<String> scheduleDetails = new ArrayList<>();
		String dateRange = "";
		String[] lines = scheduleText.split("\n");

		List<String> dates = new ArrayList<>();
		List<String> details = new ArrayList<>();

		for (String line : lines) {
			if (line.matches("\\d{4}\\.\\d{2}\\.\\d{2} ~ \\d{4}\\.\\d{2}\\.\\d{2}")) {
				dates.add(line);

			} else {
				details.add(line);
			}
		}

		dateRange = dates.get(0);

		for (int i = 0; i < details.size(); i++) {
			String line = details.get(i).trim();
			if (!line.equals("---") && line.matches("\\d+\\.\\s.*")) {
				scheduleDetails.add(line.substring(line.indexOf(" ") + 1));
			}
		}

		return new ScheduleVO(dateRange, scheduleDetails);

	}

}
