package com.interviews.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SocialNetworKTraversal {

	/*
	 * import java.util.*; import java.io.*;
	 *
	 * public List<String> getDirectFriendsForUser(String user) --- returns a
	 * list of customer IDs
	 *
	 * public List<String> getAttendedCoursesForUser(String user)
	 *
	 * Please complete the method below
	 */

	public static void main(String[] args) throws java.lang.Exception {
		getRankedCourses("Karajagi");
	}

	// getDirectFriendsForUser(String user) --- returns a list of customer IDs
	// getAttendedCoursesForUser --- returns a list of course IDs

	public  static List<String> getRankedCourses(String user) {

		List<String> result = new LinkedList<String>();

		List<String> directFriendsByUser = getDirectFriendsForUser(user);
		Map<String, List<String>> coursesListByFriends = new HashMap<String, List<String>>();

		List<String> coursesList = null;
		Map<String, Integer> counterByCourse = new HashMap<String, Integer>();

		for (String friend : directFriendsByUser) {
			coursesListByFriends.put(friend, getAttendedCoursesForUser(friend));
		}

		for (Map.Entry<String, List<String>> item : coursesListByFriends.entrySet()) {
			coursesList = item.getValue();
			for (String course : coursesList) {

				if (counterByCourse.containsKey(course)) {
					counterByCourse.put(course, counterByCourse.get(course) + 1);
				} else {
					counterByCourse.put(course, 1); // first
				}
			}
		}

		List<String> lowPopulariTy = new ArrayList<String>();
		for (Map.Entry<String, Integer> item : counterByCourse.entrySet()) {
			if (item.getValue() == 1) {
				lowPopulariTy.add(item.getKey());
			}
		}

		for (String item : lowPopulariTy) {
			counterByCourse.remove(item);
		}
		
//		Sort popularity
		Set<Map.Entry<String, Integer>> keySet = counterByCourse.entrySet();
		List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(keySet);
		Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		for (Map.Entry<String, Integer> item: resultList) {
			result.add(item.getKey());
		}

		return result;
	}

	public static List<String> getDirectFriendsForUser(String user) {
		List<String> userList = new ArrayList<String>();

		userList.add("Anand");
		userList.add("Kumar");

		return userList;
	}

	public static List<String> getAttendedCoursesForUser(String user) {
		List<String> courses = new ArrayList<String>();

		if (user.equals("Anand")) {
			courses.add("Math");
			courses.add("Sce");
		} else {
			courses.add("Eng");
			courses.add("Sce");
		}

		return courses;
	}
}
