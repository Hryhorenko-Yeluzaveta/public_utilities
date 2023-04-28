<#import "templ/templ.ftl" as c>
<@c.pages>
    <h2> Rates </h2>


    <table class="table">
        <thead>
        <tr>
            <th>images</th>
            <th>name</th>
            <th>category</th>
            <th>price</th>
        </tr>
        </thead>

        <tbody>
        <#if itemCart??>
            <#list itemCart as item>
                <tr>
                    <td><img src="${item.rate.images}" alt="image" height="40px"></td>
                    <td>${item.rate.name}</td>
                    <td>${item.rate.categories.name}</td>
                    <td>${item.rate.price}</td>
                    <form action="/deleteItem" method="post">
                        <td>
                            <input type="hidden" name="id" value="${item.rate.id}">
                            <button type="submit" class="btn btn-danger">delete</button>
                        </td>
                    </form>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <p> Total value: <a> ${totelEl} </a> ₴ </p>


    <p></p>
</@c.pages>