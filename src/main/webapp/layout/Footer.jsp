<%@ page contentType="text/html; charset=UTF-8"%>


     <form action="/codebee/sales/checkout" id="chk">
         <input type="hidden" id="items" value="" name="x"/>
     </form>

    <script type="text/javascript">
        var ex = 0;
        var xy  = new Array();
                $('#activator').click(function(){
                var kids = $('#cart_items').children();
                var url = "/codebee/sales/checkout"

            //    $('#box2').html(geturl('/codebee/sales/checkout'));

                $.each(kids,function(key,value){
                    xy.push($(value).find(".title").attr("id"));
                               });
                   console.log(xy);
                    $('#items').attr('value',xy.toString());
                  //  $.post("/codebee/sales/checkout", {x:xy.toString()},"json");
                    $('#chk').submit();

                //   $(location).attr('href',url);
            });



    </script>

<span class="copyright">&copy; 2012 Akhilesh Kumar Gupta<br />

</span>