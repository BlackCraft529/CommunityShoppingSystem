$(() => {
    $('#cate_title').on('mouseenter', () => {
        $('.dropdown').show();
    });
    $('#cate_title').on('mouseleave', () => {
        $('.dropdown').hide();
    });
    $('.dropdown').on('mouseenter', () => {
        $('.dropdown').show();
    });
    $('.dropdown').on('mouseleave', () => {
        $('.dropdown').hide();
    });
});

function showAlert(msg, bgColor = '', fontColor = '') {
    let el = "<div class=\"alert\">" + msg + "</div>";
    $('body').append(el);
    let myAlert = $('.alert');
    if (bgColor !== '') {
        $(myAlert).css('backgroundColor', bgColor);
    }
    if (fontColor !== '') {
        $(myAlert).css('color', fontColor);
    }
    myAlert.fadeIn();
    setTimeout(() => {
        myAlert.fadeOut();
        myAlert.remove();
    }, 3000);
}