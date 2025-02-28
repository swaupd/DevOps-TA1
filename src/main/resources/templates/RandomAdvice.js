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

        const title = document.createElement('h2');
        title.textContent = 'Random Advice Generator';
        title.className = 'advice-title';

        this.adviceElement = document.createElement('p');
        this.adviceElement.className = 'advice-text';
        
        this.button = document.createElement('button');
        this.button.textContent = 'Get New Advice';
        this.button.className = 'advice-button';
        
        container.appendChild(title);
        container.appendChild(this.adviceElement);
        container.appendChild(this.button);
        
        // Find the main content area or append to body
        const mainContent = document.querySelector('main') || document.body;
        mainContent.appendChild(container);

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

// Add enhanced styles with gradients
const styles = `
    .advice-container {
        max-width: 600px;
        margin: 2rem auto;
        padding: 2rem;
        text-align: center;
        font-family: 'Arial', sans-serif;
        background: linear-gradient(135deg, rgba(255,255,255,0.9) 0%, rgba(255,255,255,0.7) 100%);
        border-radius: 15px;
        box-shadow: 0 8px 32px rgba(31, 38, 135, 0.15);
        backdrop-filter: blur(4px);
        border: 1px solid rgba(255, 255, 255, 0.18);
    }

    .advice-title {
        color: #2c3e50;
        margin-bottom: 1.5rem;
        font-size: 1.8rem;
        background: linear-gradient(45deg, #2c3e50, #3498db);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
    }

    .advice-text {
        font-size: 1.3rem;
        line-height: 1.6;
        margin-bottom: 1.5rem;
        color: #34495e;
        padding: 1rem;
        background: linear-gradient(to right, rgba(255,255,255,0.8), rgba(255,255,255,0.9));
        border-radius: 8px;
    }

    .advice-button {
        padding: 1rem 2rem;
        font-size: 1.1rem;
        background: linear-gradient(45deg, #4CAF50, #45a049);
        color: white;
        border: none;
        border-radius: 25px;
        cursor: pointer;
        transition: all 0.3s ease;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;
    }

    .advice-button:hover {
        background: linear-gradient(45deg, #45a049, #4CAF50);
        transform: translateY(-2px);
        box-shadow: 0 5px 15px rgba(76, 175, 80, 0.3);
    }

    .advice-button:disabled {
        background: linear-gradient(45deg, #cccccc, #bbbbbb);
        cursor: not-allowed;
        transform: none;
        box-shadow: none;
    }
`;

const styleSheet = document.createElement('style');
styleSheet.textContent = styles;
document.head.appendChild(styleSheet);
