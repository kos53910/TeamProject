package com.gt.s.quartz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.bson.*;

@Controller
public class GtQuartzNews {
	
	@GetMapping(value = "gtQuartzNewsMongoDB", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String gtQuartzNewsMongoDB() {
		
			System.out.println("aaaaa");
			String MongoDB_IP = "192.168.0.59";
			int MongDB_PORT = 27017;
			String DB_NAME = "goats";
			
			MongoClient mongoClient = new MongoClient(new ServerAddress(MongoDB_IP,MongDB_PORT));
			DB db = mongoClient.getDB(DB_NAME);
			DBCollection collection = db.getCollection("news");
			
			System.out.println("mongoDB연결");
			DBCursor cursor = collection.find();
			String jsonResult = "";
				
			while (cursor.hasNext()) {
				jsonResult = cursor.next().toString();
				System.out.println(jsonResult);
			}
			
			System.out.println(jsonResult);
			
			return jsonResult;
			
	}
	
	@GetMapping("news")
	public String news() {
		
			return "main/news";
	}
	@GetMapping("test12")
	public String test1() {
		
		return "test/test";
	}
	
	public static void main(String[] args) {

		
		GtQuartzNews s = new GtQuartzNews();
		
		s.gtQuartzNewsMongoDB();
		
	}
}
