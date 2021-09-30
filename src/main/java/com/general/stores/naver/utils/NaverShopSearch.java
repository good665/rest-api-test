package com.general.stores.naver.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.general.stores.naver.models.ItemDto;

import java.util.ArrayList;
import java.util.List;

@Component //@RequiredArgsConstructor 와 함께 사용할 경우 스프링이 자동으로 생성
public class NaverShopSearch {
	public String search(String query) {
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Naver-Client-Id", "Client-Id ");
		headers.add("X-Naver-Client-Secret", "Client-Secret ");
		String body = "";
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers); // 넘겨받은 query로 검색 요청
		ResponseEntity<String> responseEntity = rest.exchange(
				"https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity,
				String.class);
		HttpStatus httpStatus = responseEntity.getStatusCode();
		int status = httpStatus.value();
		String response = responseEntity.getBody();
		System.out.println("Response status: " + status);
		System.out.println(response);
		return response;
	}

	public List<ItemDto> fromJSONtoItems(String result) {
		JSONObject rjson = new JSONObject(result);
		JSONArray items = rjson.getJSONArray("items");

		List<ItemDto> itemDtoList = new ArrayList<>();

		for (int i = 0; i < items.length(); i++) {
			JSONObject itemJson = items.getJSONObject(i);
			ItemDto itemDto = new ItemDto(itemJson);
			itemDtoList.add(itemDto);
		}

		return itemDtoList;
	}

}
