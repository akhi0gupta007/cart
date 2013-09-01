<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
  <head>
      <style type="text/css">

      .sidebarmenu ul{
          margin: 0;
          padding: 0;
          list-style-type: none;
          font: bold 13px Verdana;
          width: 180px; /* Main Menu Item widths */
          border-bottom: 1px solid #ccc;
      }

      .sidebarmenu ul li{
          position: relative;
      }

          /* Top level menu links style */
      .sidebarmenu ul li a{
          display: block;
          overflow: auto; /*force hasLayout in IE7 */
          color: white;
          text-decoration: none;
          padding: 6px;
          border-bottom: 1px solid #778;
          border-right: 1px solid #778;
      }

      .sidebarmenu ul li a:link, .sidebarmenu ul li a:visited, .sidebarmenu ul li a:active{
          background-color: #012D58; /*background of tabs (default state)*/
      }

      .sidebarmenu ul li a:visited{
          color: white;
      }

      .sidebarmenu ul li a:hover{
          background-color: black;
      }

          /*Sub level menu items */
      .sidebarmenu ul li ul{
          position: absolute;
          width: 170px; /*Sub Menu Items width */
          top: 0;
          visibility: hidden;
      }

      .sidebarmenu a.subfolderstyle{
          background: url(${request.contextPath}/images/right.gif) no-repeat 97% 50%;
      }


          /* Holly Hack for IE \*/
      * html .sidebarmenu ul li { float: left; height: 1%; }
      * html .sidebarmenu ul li a { height: 1%; }
          /* End */

      </style>

    
  </head>
   <body>
<div id="buddies">
<div class="title">
    <div class="sidebarmenu">
<ul id="sidebarmenu1">
<li><h2>Browse Catagories</h2></li>
    <br><br>

        <li>
    <a> 	Category 1 </a>
        </li>

   
</ul> 
 </div>
<!--
 <p><strong>LATEST TWEETS</strong></p>
<script charset="utf-8" src="http://widgets.twimg.com/j/2/widget.js"></script>
<script>
new TWTR.Widget({
  version: 2,
  type: 'profile',
  rpp: 4,
  interval: 30000,
  width: 250,
  height: 300,
  theme: {
    shell: {
      background: '#333333',
      color: '#ffffff'
    },
    tweets: {
      background: 'white',
      color: 'grey',
      links: 'black'
    }
  },
  features: {
    scrollbar: false,
    loop: false,
    live: false,
    behavior: 'all'
  }
}).render().setUser('gupta007').start();

</script>
 -->
    <br><br>



</div>
</div>
   </body>
</html>