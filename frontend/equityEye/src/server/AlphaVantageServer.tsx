import axios from 'axios';

class AlphaVantageServer {
    private apiKey: string;
    private baseUrl: string;

    constructor() {
        this.apiKey = 'UOKR5ET77YUCVF1H';
        this.baseUrl = 'https://www.alphavantage.co/query';
    }

    async getShares(symbol: string) {
        try {
            const response = await axios.get(this.baseUrl, {
                params: {
                    function: 'SYMBOL_SEARCH',
                    keywords: symbol,
                    apikey: this.apiKey,
                },
            });
            return response.data;
        } catch (error) {
            console.error('Error fetching data from Alpha Vantage:', error);
            throw error;
        }
    }
}

export default AlphaVantageServer;