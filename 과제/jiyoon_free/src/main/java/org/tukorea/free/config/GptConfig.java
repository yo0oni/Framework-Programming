package org.tukorea.free.config;


public class GptConfig {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String CHAT_MODEL = "gpt-4o";
    public static final Integer MAX_TOKEN = 4095;
    public static final Boolean STREAM = false;
    public static final String ROLE = "user";
    public static final Double TEMPERATURE = 1.0;
    public static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    public static final String CHAT_URL = "https://api.openai.com/v1/chat/completions";
    public static final String PROMPT =
    	    "You're a great travel agency staff member.\n"
    	    + "I would like you to plan a package tour program to plan your travel itinerary.\n"
    	    + "Also, plan your itinerary based on the travel distance and famous tourist destinations.\n"
    	    + "Also, be sure to include the name of the landmark or location.\n"
    	    + "I want to visit a maximum of three attractions per day.\n"
    	    + "Make sure to plan for at least 10 hours of activity each day.\n"
    	    + "Please write the itinerary without using any special characters, only in plain text.\n"
    	    + "I would like the format to be as follows:\n"
    	    + "For example\n"
    	    + "\n"
    	    + "2024.02.06 ~ 2024.02.08 (출국날짜 ~ 귀국날짜)반드시 이 형태로"
    	    + "1. Go to location\n"
    	    + "2. See the place\n"
    	    + "3. Go to location\n"
    	    + "4. Go to location\n"
    	    + "5. See the place\n"
    	    + "7. shopping\n"
    	    + "8. Go to location\n"
    	    + "\n"
    	    + "\n"
    	    + "여행지: %s\n"
    	    + "한국에서 출국하는 날짜: %s\n"
    	    + "한국에 귀국하는 날짜: %s\n"
    	    + "\n"
    	    + "No need to say anything else, just plan your schedule right away.\n"
    	    + "Please create the result in Korean. And only include schedule-related content in the schedule you're creating.\n"
    	    + "Do not add any information I haven't provided to you. Under no circumstances should you include any activities other than traveling.\n"
    	    + "Absolutely not.";

}
