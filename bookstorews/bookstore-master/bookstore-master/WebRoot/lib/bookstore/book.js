$(document).ready(function(){
    loadBooks();
});

function loadBooks() {
    $.getJSON("./books").done(function(books){
        updateBooksView(books);
    }).fail(function(e){
        console.log(e);
    });
}




function updateBooksView(books) {
    $("#booksView").empty();
    for (var book of books) {
        var view = $(`
            <div class="col-md-4">
               <div class="card">
                   <div class="card-body pb-5">
                       <div class="pt-4 pb-5">
                           <img src="" class="img-fluid img-center" style="height: 150px;" alt="Illustration" />
                       </div>
                       <h5 class="h4 lh-130 mb-3"></h5>
                       <p class="text-muted mb-0 price"></p>
                       <p class="text-muted mb-0 content"></p>
                   </div>
               </div>
            </div>
        `);
        view.find("img").attr("src", "./image/upload/" + book.picture);
        view.find("h5").append(book.name);
        view.find("p.price").append("作者：" + book.author + "， 价格：" + book.price);
        view.find("p.content").append(book.content);
        $("#booksView").append(view);
    }
}

function updateBooksView2(books) {
    var table = $("<table class='tb-book'></table>");
    for (var book of books) {
        var tr = $("<tr></tr>");
        tr.append("<td>" + book.name + "</td>");
        tr.append("<td>" + book.author + "</td>");
        tr.append("<td>" + book.price + "</td>");
        tr.append("<td>" + book.content + "</td>");
        tr.append("<td><img src='./image/upload/" + book.picture + "'/></td>");
        table.append(tr);
    }
    $("#booksView").empty().append(table);
}


