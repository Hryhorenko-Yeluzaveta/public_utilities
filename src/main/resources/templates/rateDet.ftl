<#import "templ/templ.ftl" as p>
<@p.pages>

    <h1>Rate - ${rate.name}</h1>

    <p>${rate.id}</p>
    <p>${rate.name}</p>
    <p>${rate.price}</p>
    <p>${rate.images}</p>
    <p>${rate.categories.name}</p>

</@p.pages>