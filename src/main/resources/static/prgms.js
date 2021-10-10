let targetId;

$(document).ready(function () {
	
	$('#new_id').on('keypress',function(e) {
		if (e.key == 'Enter'){
			execSearch();
		}
	});
	$('.nav div.nav-search').on('click', function () {
        $('div.nav-search').addClass('active');
        $('#search-area').show();
    })
    
    $('#search-area').show();
    

function execSearch() {
	    /**
     * 검색어 input id: new_id
     * 검색결과 목록: #search-result-box
     * 검색결과 HTML 만드는 함수: addHTML
     */
    $('#search-result-box').empty();
    // 1. 검색창의 입력값을 가져온다.
    let new_id = $('#new_id').val();
    if (new_id == '') {
        alert('검색어를 입력해주세요.');
        $('#new_id').focus();
    }
    // 3. GET /api/new_id?new_id=${new_id} 요청
    $.ajax({
		type: 'POST',
        //url: `/api/new_id?new_id=${answer}`,
        url: `/new_id`,
        //url: `/plus`,
        success: function (answer) {
            // 4. for 문마다 itemDto를 꺼내서 HTML 만들고 검색결과 목록에 붙이기!           
                let idDto = answer;
                let tempHtml = addHTML(idDto);
                $('#search-result-box').append(tempHtml);
            
	}
	})
	}
function addHTML(idDto) {
	return `<div class="search-itemDto">
		<div class="search-itemDto-center">
                    <div>${idDto.new_id}</div>
                    <div>${new_id}</div>
                    </div>
            </div>`
	}
	
function addProduct(itemDto) {
    /**
     * modal 뜨게 하는 법: $('#container').addClass('active');
     * data를 ajax로 전달할 때는 두 가지가 매우 중요
     * 1. contentType: "application/json",
     * 2. data: JSON.stringify(itemDto),
     */
    // 1. POST /api/products 에 관심 상품 생성 요청
}
});