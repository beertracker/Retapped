import React, {useState, useEffect} from 'react'
import beerFetchingService from '../services/beerFetchingService';

// creates a new search bar
function searchBarComponent()
{
    const [beers, setbeers = useState([]);

    useEffect(() => {
        getBeer()
    }, [])

    const getBeer() = () => {

        beerFetchingService.getBeer().then((response) => {

            setbeers(response.data)
            console.log(response.data);

        });
    };


}

export default searchBarComponent()
