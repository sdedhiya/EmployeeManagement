// main.js
window.onload = () => {
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => alert.style.display = 'none', 3000);
    });
};
