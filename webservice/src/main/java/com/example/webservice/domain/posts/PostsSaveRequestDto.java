package com.example.webservice.domain.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
	여기서 Entity 클래스와 거의 유사한 형태임에도 DTO 클래스를 추가로 생성했는데요.
	절대로 테이블과 매핑되는 Entity 클래스를 Request/ Response 클래스로 사용해서는 안됩니다.
	Entity 클래스는 가장 Core 한 클래스라고 보시면 되는데요.
	수많은 서비스 클래스나 비지니스 로직들이 Entity 클래스를 기준으로 동작합니다.
	Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면 Request 와 Response 용 DTO 는 View 를 위한 클래스라 정말 자주 변경이 필요합니다.
	View Layer 와 DB Layer 를 철저하게 역할 분리를 하는게 좋습니다.
	실제로 Controller 에서 결과값으로 여러 테이블을 조인해서 줘야할 경우가 빈번하기 때문에 Entity 클래스만으로 표현하기가 어려운 경우가 많습니다.
	꼭꼭 Entity 클래스와 Controller 에서 쓸 DTO 는 분리해서 사용하시길 바랍니다.
 **/

@Getter
@AllArgsConstructor
public class PostsSaveRequestDto {
	private String title;
	private String content;
	private String author;

	public Posts toEntity() {
		return Posts.builder().title(title).content(content).author(author).build();
	}
}