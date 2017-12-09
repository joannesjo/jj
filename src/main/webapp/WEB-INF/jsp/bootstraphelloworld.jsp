<%@ page import="java.security.MessageDigest" %>
<%@ page import="static java.util.Objects.hash" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03-12-2017
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>

<html>
<head>
    <title>Spring Boot - POST-GET AJAX Example</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" >
    <link rel="stylesheet" href="/webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
    <script id="bolt" src="https://sboxcheckout-static.citruspay.com/bolt/run/bolt.min.js" bolt-color="<color-code>" bolt-logo="<image path>"></script></head>
<body>
<%
   String hashSequence =
           "X9259yxk|jp222|10|Bag|joannes|joannes.webd@gmail.com|udf1|brfVQKZrVX";
   int hash = hash("sha512", hashSequence);
  /*  MessageDigest md = MessageDigest.getInstance("sha512", hashSequence);
   String hash="";
    byte[] mb  = md.digest();
    for (int i = 0; i < mb.length; i++) {
        byte temp = mb[i];
        String s = Integer.toHexString(new Byte(temp));
        while (s.length() < 2) {
            s = "0" + s;
        }
        s = s.substring(s.length() - 2);
        hash += s;
    }
*/
%>
<script>
    bolt.launch({
        key: 'X9259yxk',
        txnid: 'jp222',
        hash: '<%=hash%>',
        amount: '10',
        firstname: 'joannes',
        email: 'joannes.webd@gmail.com',
        phone: '9500003698',
        productinfo: 'Bag',
        surl : 'http://192.168.43.81:8080/testredirect',
        furl: 'http://192.168.43.81:8080/testredirect'
    },{ responseHandler: function(response){
// your payment response Code goes here
        console.log( response.txnStatus );
        alert(response.message);
    },
        catchException: function(response){
            console.log( response.message);
            alert(response.message);
// the code you use to handle the integration errors goes here
        }
    });
</script>
<div class="container">
    <h1>Bootstrap Modal</h1>
    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" id="btnId">Open Modal</button>

    <!-- Bootstrap Modal -->
    <div class="modal fade" id="modalId" role="dialog">
        <div class="modal-dialog">

            <!-- Bootstrap Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Header</h4>
                </div>
                <div class="modal-body">
                    <p id="greetingId"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div>
        INSTAMOJO
        <a href="https://www.instamojo.com/@joannesjo/l76fa1f34ef344d40a2761c317cb24310/" rel="im-checkout" data-behaviour="remote" data-style="light" data-text="Checkout With Instamojo"></a>
        <script src="https://js.instamojo.com/v1/button.js"></script>
    </div>
</div>

<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script src="/js/getrequest.js"></script>
</body>
</html>