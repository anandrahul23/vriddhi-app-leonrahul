import axios from 'axios';
import TickerDetails from './TickerDetails';


class PolygonServer {
    private apiKey: string;
    private baseUrl: string;
    private cache: { [key: string]: TickerDetails };

    constructor() {
        this.apiKey = '        docker ps -a -f "status=exited"';
        this.baseUrl = 'https://api.polygon.io/v3/reference/tickers';
        this.cache = {};
    }



    async getAllTickerDetails() {

        if (Object.keys(this.cache).length > 0) {
                return this.cache;
            }

        await this.loadCacheFromFile('../assets/data/AllTickers.json');

        if (Object.keys(this.cache).length > 0) {
            return this.cache;
        }

        try {
            const response = await axios.get(`${this.baseUrl}`, {
                params: {
                    apiKey: this.apiKey,
                    active: true,
                    limit: 10,  // Limit the number of results to 10
                    order: 'asc',  // Order the results in ascending order
                    market: 'stocks',  // Filter by market
                    // exchange: 'XNYS',  // Filter by exchange

                },
            });
              const tickers = response.data.results || [];
            tickers.forEach((ticker: TickerDetails) => {
                this.cache[ticker.ticker] = ticker;
            });
            await this.writeCacheToFile('../assets/data/AllTickers.json');

            return this.cache;
        } catch (error) {
            console.error('Error fetching ticker details:', error);
            throw error;
        }
    }


     async loadCacheFromFile(filePath: string) {
        if (typeof window === 'undefined') {
            // Node.js environment
            const { promises: fs } = await import('fs');
            const path = await import('path');
            try {
                const data = await fs.readFile(path.resolve(__dirname, filePath), 'utf-8');
                this.cache = JSON.parse(data);
                console.log('Cache loaded from file');
            } catch (error) {
                console.error('Error reading cache from file:', error);
            }
        } else {
            // Browser environment
            try {
                const response = await fetch(filePath);
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                this.cache = await response.json();
                console.log('Cache loaded from file');
            } catch (error) {
                console.error('Error reading cache from file:', error);
            }
        }
    }

    searchCache(query: string): TickerDetails[] {
        const lowerCaseQuery = query.toLowerCase();
        return Object.values(this.cache).filter(ticker =>
            ticker.ticker.toLowerCase().includes(lowerCaseQuery) ||
            ticker.name.toLowerCase().includes(lowerCaseQuery)
        );
    }

     async writeCacheToFile(filePath: string) {
        if (typeof window === 'undefined') {
             // Node.js environment
            const { promises: fs } = await import('fs');
            try {
            const data = JSON.stringify(this.cache, null, 2);
            await fs.writeFile(filePath, data, 'utf-8');
            console.log(`Cache written to ${filePath}`);
            } catch (error) {
            console.error('Error writing cache to file:', error);
            throw error;
            }
        } else {
            // Browser environment
            try {
            const response = await fetch(filePath, {
                method: 'PUT',
                headers: {
                'Content-Type': 'application/json',
                },
                body: JSON.stringify(this.cache, null, 2),
            });
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log(`Cache written to ${filePath}`);
            } catch (error) {
            console.error('Error writing cache to file:', error);
            throw error;
            }
        }
    }
}

export default PolygonServer;   