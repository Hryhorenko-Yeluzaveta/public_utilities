<#import "parts/templadmin.ftl" as p>
<@p.pages>
    <h1>Rates</h1>
    <p></p>
    <hr>
    <h2> Save Rate to DB </h2>

    <form action="/saveNewRate" method="post">


        <table>
            <tbody>
            <tr>
                <td><label for="name">Name</label><br>
                    <input type="text" name="name" placeholder="name" id="name"><br>
                </td>
            </tr>
            <tr>
                <td><label for="image">Image</label><br>
                    <input type="text" name="image" id="image" placeholder="link"><br>
                </td>
            </tr>

            <tr>
                <td><label for="price">Price</label><br>
                    <input type="number" name="price" id="price" placeholder="price"><br>
                </td>
            </tr>

            <tr>

                <#--                -->
                <td><label for="category">Category</label><br>

                    <select name="categoryId">

                        <#list allCategory as category>
                        <#--                        <#if "${category.id}"=="6">-->
                        <#--                        <option value="${category.id}" selected>${category.name}</option>-->
                        <#--                        <#else>-->
                            <option value="${category.id}">${category.name}</option>
                        <#--                        </#if>-->
                        </#list>

                    </select>
                    <br>
                </td>

                <#--                -->
            </tr>

            <tr>
                <td>
                    <input type="submit" value="save">
                </td>
            </tr>
            </tbody>
        </table>


        <br>
        <hr>
        <h2> RateList </h2>

        <table>
            <thead>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Image</td>
                <td>Price</td>
                <td>Category</td>
            </tr>
            </thead>

            <tbody>

            <#if allRate??>
                <#list allRate as rate>
                    <tr>
                        <td>${rate.id}</td>
                        <td><a href="/ratemanager/${rate.id}"> ${rate.name} </a></td>
                        <td>${rate.image}</td>
                        <td>${rate.price}</td>
                        <td>${rate.categories.name}</td>
                    </tr>
                </#list>
            </#if>

            </tbody>
        </table>

        <br>
        <hr>


    </form>



    <br>
    <hr>
    <h2> Update/Delete </h2>

    <table>
        <thead>
        <tr>
            <#--            <td>Id</td>-->
            <td>Name</td>
            <td>Image</td>
            <td>Price</td>
            <td>Category
            <td>Update</td>
            <td>Delete</td>
        </tr>
        </thead>

        <tbody>

        <#if allRate??>
            <#list allRate as rate>

                <form action="/updateRate" method="post">
                    <tr>
                        <#--                    <td>-->
                        <input type="hidden" name="id" value="${rate.id}">
                        <#--                    </td>-->
                        <td>
                            <input type="text" name="name" value="${rate.name}">
                        </td>
                        <td><input type="text" name="image" value="${rate.image}"></td>
                        <td><input type="text" name="price" value="${rate.price}"></td>
                        <td>
                            <select name="categoryId">
                                <#list allCategory as category>
                                    <#if "${category.id}"=="${rate.categories.id}">
                                        <option value="${category.id}" selected>${category.name}</option>
                                    <#else>
                                        <option value="${category.id}">${category.name}</option>
                                    </#if>
                                </#list>
                            </select>


                        </td>

                        <td><input type="submit" value="update"></td>
                </form>


                <td>
                    <form action="/deleteRate" method="post">
                        <input type="hidden" name="id" value="${rate.id}">
                        <input type="submit" value="delete">
                    </form>
                </td>
                </tr>
            </#list>
        </#if>

        </tbody>
    </table>

    <br>
    <hr>
    <h2> Delete All Rate </h2>
    <form method="post" action="/deleteAllRate">
        <input type="submit" value="delete">
    </form>
    <br>
    <hr>
    </form>

</@p.pages>