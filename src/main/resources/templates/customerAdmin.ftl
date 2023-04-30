<#import "parts/templadmin.ftl" as p>
<@p.pages>

    <#if customers??>
        <h1>Customers</h1>
        <#list customers as customer>
            <ul>
                <li>${customer.id}</li>
                <li>${customer.firstName}</li>
                <li>${customer.lastName}</li>
                <li>Username : ${customer.user.username}</li>
                <li>Password : ${customer.user.password}</li>
                <li>${customer.email}</li>
                <li>${customer.phone}</li>
                <li>${customer.address}</li>
            </ul>
        </#list>
    </#if>

</@p.pages>