import axios from 'axios';

// default URL from the controller to pass to axios
const BEER_API_BASE_URL = 'http://localhost:8080/grabABeer';

// creates a search bar that calls GET to grabABeer using axios. Displays as a table
class beerFetchingService
{
    getBeer()
    {
        return axios.get(BEER_API_BASE_URL);
    }
}

export default new beerFetchingService();


