<#import "templ/templ.ftl" as c>
<@c.pages>

    <h1> Order </h1>
    <table class="table">
        <thead>
        <tr>
            <th>image</th>
            <th>name</th>
            <th>rate</th>
            <th>totalBill</th>
        </tr>
        </thead>

        <tbody>
        <#if itemCart??>
            <#list itemCart as item>
                <tr>
                    <td><img src="${item.rate.images}" alt="${item.rate.name}" height="40px"></td>
                    <td>${item.rate.name}</td>
                    <td>${item.rate.price}</td>


                    <td id="price">${item.index*item.rate.getPrice()}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

<#--    <p> Total value: <a> ${totalValue} </a></p>-->

    <h2>Client</h2>

    <table class="table">
        <thead>
        <tr>
            <th>firstName</th>
            <th>lastName</th>
            <th>username</th>
            <th>phone</th>
            <th>email</th>
            <th>address</th>
            <th>payment</th>
            <th>status</th>
        </tr>
        </thead>
        <tbody>
        <form action="/order" method="post">
            <tr>

                <td>${client.firstname}</td>
                <td>${client.lastname}</td>
                <td>${client.user.username}</td>
                <td>${client.phone}</td>
                <td>${client.email}</td>
                <td>${client.address}</td>
                <td>
                    <select name="payment">
                        <option value="cash" selected>Cash</option>
                        <option value="card">Card</option>
                    </select>
                </td>
                <td>
                    <select name="status">
                        <option value="true" selected>Оплачено</option>
                        <option value="false">Не оплачено</option>
                    </select>

                </td>
                <td> <button type="submit">Add to DB</button> </td>

            </tr>
        </form>
        </tbody>
    </table>
</@c.pages>
