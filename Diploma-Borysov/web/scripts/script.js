$(function () {                                      // Когда страница загрузится
    $('#menu li a').each(function () {             // получаем все нужные нам ссылки

        var link = this.href;                // получаем адрес ссылки

        var location = window.location.href; // получаем адрес страницы
        var splitLink = location.split('?')[0]
        if(splitLink == link) {               // при совпадении адреса ссылки и адреса окна
            /*alert('link    '+link);
            alert("location   "+location);*/
            $(this).parent().addClass('selected');  //добавляем класс
        }
    });
});