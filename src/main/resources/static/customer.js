

$("form").submit(function () {
    var btn = $(this).find("input[type=submit]:focus" );
    var btnName = btn.attr('name');
    var input = $("<input>")
        .attr("name", "btnName").val(btnName);
    $(this).append(input);
    return true;
});
