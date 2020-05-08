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