class RandomAdvice {
    constructor() {
        this.adviceText = '';
        this.adviceElement = null;
        this.button = null;
        this.initialize();
    }

    initialize() {
        // Create and append elements
        const container = document.createElement('div');
        container.className = 'advice-container';

        this.adviceElement = document.createElement('p');
        this.adviceElement.className = 'advice-text';
        
        this.button = document.createElement('button');
        this.button.textContent = 'Get New Advice';
        this.button.className = 'advice-button';
        
        container.appendChild(this.adviceElement);
        container.appendChild(this.button);
        
        document.body.appendChild(container);

        // Add event listener
        this.button.addEventListener('click', () => this.fetchAdvice());
        
        // Get initial advice
        this.fetchAdvice();
    }

    async fetchAdvice() {
        try {
            this.button.disabled = true;
            const response = await fetch('https://api.adviceslip.com/advice');
            const data = await response.json();
            this.adviceText = data.slip.advice;
            this.adviceElement.textContent = this.adviceText;
        } catch (error) {
            console.error('Error fetching advice:', error);
            this.adviceElement.textContent = 'Failed to load advice. Please try again.';
        } finally {
            this.button.disabled = false;
        }
    }
}

// Initialize the advice generator when the DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new RandomAdvice();
});

// Add some basic styles
const styles = `
    .advice-container {
        max-width: 600px;
        margin: 2rem auto;
        padding: 1rem;
        text-align: center;
        font-family: Arial, sans-serif;
    }

    .advice-text {
        font-size: 1.2rem;
        line-height: 1.6;
        margin-bottom: 1rem;
        color: #333;
    }

    .advice-button {
        padding: 0.8rem 1.5rem;
        font-size: 1rem;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .advice-button:hover {
        background-color: #45a049;
    }

    .advice-button:disabled {
        background-color: #cccccc;
        cursor: not-allowed;
    }
`;

const styleSheet = document.createElement('style');
styleSheet.textContent = styles;
document.head.appendChild(styleSheet);
