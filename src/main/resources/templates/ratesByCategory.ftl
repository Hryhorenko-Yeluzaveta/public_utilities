<#import "templ/templ.ftl" as c>
<@c.pages>
    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if allRatesByCategory??>
            <#list allRatesByCategory as rates>
                <div class="col">
                    <div class="card">

                        <form action="/cart" method="post">

                            <input type="hidden" name="id" id="id_" value="${rates.id}">
                            <img src="${rates.images}" class="card-img-top" alt="${rates.name}">
                            <div class="card-body">
                                <p></p>
                                <h5 class="card-title">Назва компанії: ${rates.name}</h5>
                                <p></p>
                                <p class="card-text">Тариф: ${rates.price}</p>
                                <#--                                <div>-->
                                <#--                                    <button class="minus btn btn-success"> - </button>-->
                                <#--                                    <input type="text" name="quantity" value="1" size="3">-->
                                <#--                                    <button class="plus btn btn-success"> + </button>-->
                                <#--                                    <p class="my_text"> </p>-->
                                <#--                                </div>-->
                                <p></p>

                                <label for="index">Index</label>
                                <input type="index" id="index" name="index" placeholder="index">

                                <p></p>


                                <button type="submit" class="btn btn-primary"> Add to Cart</button>
                                <a href="/category" class="card-link" class="btn btn-success">to category</a>
                            </div>
                        </form>
                    </div>
                </div>
            </#list>
        </#if>

    </div>

</@c.pages>