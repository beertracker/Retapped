import React, {useState, useEffect} from 'react';
import beerFetchingService from "./service/beerFetchingService";

export default function SearchBarComponent() {

    const [beers, setBeers] = useState([]);

    useEffect(() => {
        beerFetchingService.getBeer();
    }, []);

    const getbeers = () => {

        beerFetchingService.getBeer().then((response) => {
            setBeers(response.data)
            console.log(response.data);
        });
    };

    return (
        <div className = "container">
            <h1 className = "text-center">Beer List</h1>
            <table className = "table table-striped">
                <thead>
                <tr>
                    <th> Beer Id</th>
                    <th> Name</th>
                    <th> ABV</th>
                    <th> Type</th>
                    <th> IBU</th>
                </tr>
                </thead>
                <tbody>
                {
                    beers.map(
                        Beer =>
                            <tr key = {Beer.id}>
                                <td> {Beer.id }</td>
                                <td> {Beer.name }</td>
                                <td> {Beer.abv }</td>
                                <td> {Beer.type }</td>
                                <td> {Beer.ibu}</td>
                            </tr>

                    )
                }
                </tbody>
            </table>
        </div>
    )
}

// export default SearchBarComponent()