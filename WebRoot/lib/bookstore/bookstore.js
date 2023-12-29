$(document).ready(function(){
    loadBooks();
});

function loadBooks(){
    $.getJSON("./books").done(function(books){
        console.log(books);
        updateBooksView(books);
    }).fail(function(ex){
        console.log(ex);
    });
}

function updateBooksView(books){
//    var div =$(`
//    <div class="col-md-4">
//        <div class="card">
//            <div class="card-body pb-5">
//                <div class="pt-4 pb-5">
//                    <img src="" class="img-fluid img-center" style="height: 150px;" alt="Illustration" />
//                </div>
//                <h5 class="h4 lh-130 mb-3"></h5>
//                <p class="text-muted mb-0"></p>
//            </div>
//        </div>
//    </div>
//    `);
    for (var book of books){

        var div =$(`
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body pb-5">
                        <div class="pt-4 pb-5">
                            <img src="" class="img-fluid img-center" style="height: 150px;" alt="Illustration" />
                        </div>
                        <h5 class="h4 lh-130 mb-3"></h5>
                        <p class="text-muted mb-0 author-price"></p>
                        <p class="text-muted mb-0 content"></p>
                    </div>
                </div>
            </div>
            `);


        div.find("img").attr("src","./image/upload/" + book.picture);
        div.find("h5").append(book.name);
        div.find("p.author-price").append("作者："+book.author+",价格：¥"+ book.price);
        div.find("p.content").append(book.content);
        $("#booksView").append(div);



    }




}



function updateBooksView2(books){
    var table = $("<table class = 'tb-book'></table>");//dom node to jquery obj
    for(var book of books){
    var tr = $("<tr></tr>");
    $("<td></td>").append(book.id).appendTo(tr);
    $("<td></td>").append(book.name).appendTo(tr);
    $("<td></td>").append(book.author).appendTo(tr);
    $("<td></td>").append(book.price).appendTo(tr);
    $("<td></td>").append(book.content).appendTo(tr);
    $("<td></td>").append("<img class='book-pic' src = './image/upload/"+book.picture+"'/>").appendTo(tr);
    table.append(tr);

    }
    $("#booksView").append(table);
}















